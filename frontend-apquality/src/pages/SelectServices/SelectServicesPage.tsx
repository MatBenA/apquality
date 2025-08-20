import { Button } from "@/components/ui/button";
import { Checkbox } from "@/components/ui/checkbox";
import { Label } from "@/components/ui/label";
import { Separator } from "@/components/ui/separator";
import { useNavigate } from "react-router";

export const SelectServicesPage = () => {

  const navigate = useNavigate()

  return (
    <div className="flex flex-col items-center w-full p-5">
      <div className="flex flex-col items-center gap-10 w-full max-w-xl">
        <div>
          <h1 className="text-2xl font-thin">¿Qué servicios querés?</h1>
        </div>
        <div className="flex flex-col gap-5 w-full">
          <div className="flex gap-3 bg-secondary px-3 rounded-lg items-center">
            <Checkbox id="cabello" />
            <Label htmlFor="cabello" className="flex w-full justify-between h-10">
              <span>Corte de cabello</span>
              <span>$1,599</span>
            </Label>
          </div>
          <div className="flex gap-3 bg-secondary px-3 rounded-lg items-center">
            <Checkbox id="cejas" />
            <Label htmlFor="cejas" className="flex w-full justify-between h-10">
              <div>Corte de cabello</div>
              <div>$1,599</div>
            </Label>
          </div>
          <div className="flex gap-3 bg-secondary px-3 rounded-lg items-center">
            <Checkbox id="barba" />
            <Label htmlFor="barba" className="flex w-full justify-between h-10">
              <div>Corte de cabello</div>
              <div>$1,599</div>
            </Label>
          </div>
          <div className="flex gap-3 bg-secondary px-3 rounded-lg items-center">
            <Checkbox id="teñido" />
            <Label htmlFor="teñido" className="flex w-full justify-between h-10">
              <div>Corte de cabello</div>
              <div>$1,599</div>
            </Label>
          </div>
          <div className="flex gap-3 bg-secondary px-3 rounded-lg items-center">
            <Checkbox id="lavado" />
            <Label htmlFor="lavado" className="flex w-full justify-between h-10">
              <div>Corte de cabello</div>
              <div>$1,599</div>
            </Label>
          </div>
        </div>
        <div className="flex flex-col w-full">
          <div className="flex w-full justify-between">
            <div>Subtotal:</div>
            <div>$7000</div>
          </div>
          <Separator className="my-4"/>
          <div className="flex justify-between">
            <div>Total:</div>
            <div>$7000</div>
          </div>
        </div>
        <div className="flex w-full gap-5">
          <Button onClick={() => navigate(-1)} className="grow cursor-pointer" variant="secondary">Atrás</Button>
          <Button onClick={() => navigate("/reserva/resumen")} className="grow cursor-pointer">Continuar</Button>
        </div>
      </div>
    </div>
  );
};
