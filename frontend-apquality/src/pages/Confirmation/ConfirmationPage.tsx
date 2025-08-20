import { Button } from "@/components/ui/button";
import { CircleCheckBig } from "lucide-react";
import { useNavigate } from "react-router";

export const ConfirmationPage = () => {
  const navigate = useNavigate();
  return (
    <div className="flex justify-center items-center h-screen">
      <div className="flex flex-col items-center w-full max-w-2xs gap-5">
        <CircleCheckBig size={80} color="#15dd68ff" />
        <h1 className="text-3xl">¡Turno Confirmado!</h1>
        <span className="font-thin text-xl">¡Nos vemos pronto!</span>
        <Button
          onClick={() => navigate("/reserva/ubicacion")}
          className="w-full cursor-pointer"
        >
          Volver a Inicio
        </Button>
      </div>
    </div>
  );
};
