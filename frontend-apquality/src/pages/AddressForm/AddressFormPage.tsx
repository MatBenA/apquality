import {
  Form,
  FormControl,
  FormDescription,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from "@/components/ui/form";
import { Input } from "@/components/ui/input";
import { zodResolver } from "@hookform/resolvers/zod";
import { useForm } from "react-hook-form";
import z from "zod";

const addressSchema = z.object({
  name: z
    .string()
    .min(1, "El nombre es obligatorio")
    .max(50, "El nombre no debe superar los 50 caracteres"),
  phone: z
    .string()
    .regex(/^[0-9]+$/, "El teléfono solo debe contener números")
    .min(8, "El teléfono debe tener como mínimo 8 dígitos")
    .max(15, "El teléfono no puede tener más de 15 dígitos"),
  address: z
    .string()
    .min(5, "La dirección debe tener al menos 5 caracteres")
    .max(200, "La direccion no debe superar los 200 caracteres"),
});

type ClientData = z.infer<typeof addressSchema>;

export const AddressFormPage = () => {
  const clientDataForm = useForm<ClientData>({
    resolver: zodResolver(addressSchema),
    defaultValues: {
      name: "",
      phone: "",
      address: "",
    },
  });

  const onSubmit = (clientData: ClientData) => {
    console.log(clientData);
  };

  return (
    <div>
      <Form {...clientDataForm}>
        <form>
          <FormField
            control={clientDataForm.control}
            name="name"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Nombre</FormLabel>
                <FormControl>
                  <Input placeholder="" {...field} />
                </FormControl>
                <FormDescription>
                  Con este nombre podemos identificarlo
                </FormDescription>
                <FormMessage />
              </FormItem>
            )}
          />
        </form>
      </Form>
    </div>
  );
};
