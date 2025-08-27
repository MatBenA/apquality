import { CustomInput } from "@/components/CustomInput";
import { Button } from "@/components/ui/button";
import { Form } from "@/components/ui/form";
import { addressSchema, type ClientData } from "@/models/ClientDataModel";
import { zodResolver } from "@hookform/resolvers/zod";
import { useForm } from "react-hook-form";

export const AddressFormPage = () => {
  const clientDataForm = useForm<ClientData>({
    resolver: zodResolver(addressSchema),
    mode: "onBlur",
    defaultValues: {
      name: "",
      phone: "",
      address: "",
      details: "",
    },
  });

  const onSubmit = (clientData: ClientData) => {
    console.log(clientData);
  };

  return (
    <div className="flex justify-center p-5">
      <div className="flex flex-col w-full max-w-xl">
        <Form {...clientDataForm}>
          <form onSubmit={clientDataForm.handleSubmit(onSubmit)} className="gap-5">
            <CustomInput
              name={"name"}
              label="Nombre"
              placeholder="Ingrese su nombre"
              description="Con este nombre podemos identificarlo"
              control={clientDataForm.control}
            />
            <CustomInput
              name={"phone"}
              label="Telefono"
              placeholder="555-555-5555"
              description="Con su contacto podremos comunicarnos con usted"
              control={clientDataForm.control}
            />
            <CustomInput
              name={"address"}
              label="Dirección"
              placeholder="Calle x N 5555 Primer piso, departamento A"
              description="Necesitamos su direccion para ubicarlo"
              control={clientDataForm.control}
            />
            <CustomInput
              name={"details"}
              label="Detalles (opcional)"
              description="Cualquier dato extra"
              control={clientDataForm.control}
            />
            <Button type="submit">Enviar</Button>
          </form>
        </Form>
      </div>
    </div>
  );
};
