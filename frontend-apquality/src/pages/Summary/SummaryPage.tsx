import { Button } from "@/components/ui/button";
import { Separator } from "@/components/ui/separator";
import { CheckIcon } from "lucide-react";
import { useNavigate } from "react-router";

export const SummaryPage = () => {
  const navigate = useNavigate();
  return (
    <div className="flex justify-center p-5">
      <div className="flex flex-col w-full max-w-xl gap-5">
        <h1 className="text-2xl text-center font-thin">Resumen</h1>
        <div>
          <div className="flex flex-col gap-3">
            <div className="flex justify-between">
              <span>Tipo de servicio:</span>
              <span>En el local</span>
            </div>
            <div className="flex justify-between">
              <span>Fecha:</span>
              <span>Domingo, 17 de Agosto de 2025</span>
            </div>
            <div className="flex justify-between">
              <span>Horario:</span>
              <span>16:00</span>
            </div>
          </div>
          <Separator className="my-5" />
          <div className="flex flex-col gap-3">
            <span className="text-xl">Servicios</span>
            <div className="flex justify-between">
              <span>Cabello:</span>
              <span>$7000</span>
            </div>
            <div className="flex justify-between">
              <span>Cabello:</span>
              <span>$7000</span>
            </div>
            <div className="flex justify-between">
              <span>Cabello:</span>
              <span>$7000</span>
            </div>
          </div>
          <Separator className="my-5" />
          <div className="flex justify-between">
            <span className="text-xl font-bold">Total:</span>
            <span className="text-xl font-bold">$20000</span>
          </div>
        </div>
        <div className="flex gap-5">
          <Button
            variant="secondary"
            className="cursor-pointer grow"
            onClick={() => navigate(-1)}
          >
            Atrás
          </Button>
          <Button
            className="cursor-pointer grow"
            onClick={() => navigate("/reserva/confirmacion")}
          >
            <CheckIcon />
            Confirmar turno
          </Button>
        </div>
      </div>
    </div>
  );
};
