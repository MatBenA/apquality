import { Input } from "./ui/input";
import { Label } from "./ui/label";
import { Controller, type Control, type FieldError } from "react-hook-form";
import type { LoginValues } from "@/models/LoginModel";
import type { z, ZodObject } from "zod";

interface Props {
  name: z.infer<typeof ZodObject>
  control: Control<LoginValues>
  label: string
  type?: string
  error?: FieldError
}

export const InputForm = ({name, control, label, type, error}: Props) => {
  return (
    <div className="grid gap-3">
      <Label htmlFor={name}>{label}</Label>
      <Controller 
        name={name}
        control={control}
        render={({field}) => 
          <Input 
            id={name}
            type={type}
            {...field}
            className={`form-control ${error ? "is-invalid" : ""}`
          }
            />}
      />
    </div>
  );
};
