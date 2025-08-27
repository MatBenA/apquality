import { z } from "zod";

export const addressSchema = z.object({
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
  details: z.string(),
});

export type ClientData = z.infer<typeof addressSchema>;
