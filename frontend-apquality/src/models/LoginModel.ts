import { z } from "zod";

export const schema = z.object({
  email: z.email("El email es inválido").min(1, "El email es obligatorio"),
  password: z.string("La contraseña es obligatoria"),
})

export type LoginValues = z.infer<typeof schema>;