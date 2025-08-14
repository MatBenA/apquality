import { cn } from "@/lib/utils";
import { Button } from "@/components/ui/button";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { InputForm } from "./InputForm";
import { useForm, type SubmitHandler } from "react-hook-form";
import { type LoginValues, schema } from "@/models/LoginModel";
import { zodResolver } from "@hookform/resolvers/zod";

export function LoginForm({
  className,
  ...props
}: React.ComponentProps<"form">) {
  const { control, handleSubmit, formState: { errors } } = useForm<LoginValues>({
    resolver: zodResolver(schema),
  });

  const onSubmit: SubmitHandler<LoginValues> = (data) => {
    console.log(data);
  };

  return (
    <form
      className={cn("flex flex-col gap-6", className)}
      {...props}
      onSubmit={handleSubmit(onSubmit)}
    >
      <Card>
        <CardHeader>
          <CardTitle>Ingresa a tu cuenta</CardTitle>
        </CardHeader>
        <CardContent>
          <form>
            <div className="flex flex-col gap-6">
              <InputForm
                name="email"
                control={control}
                label="Email"
                type="email"
                error={errors.email}
              />
              <InputForm
                name="password"
                control={control}
                label="Contraseña"
                type="password"
                error={errors.password}
              />
              <div className="flex flex-col gap-3">
                <Button type="submit" className="w-full">
                  Ingresar
                </Button>
              </div>
            </div>
          </form>
        </CardContent>
      </Card>
    </form>
  );
}
