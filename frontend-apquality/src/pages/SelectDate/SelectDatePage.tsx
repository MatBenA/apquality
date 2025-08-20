import { Button } from "@/components/ui/button";
import { Calendar } from "@/components/ui/calendar";
import {
  Popover,
  PopoverContent,
  PopoverTrigger,
} from "@/components/ui/popover";
import { Toggle } from "@/components/ui/toggle";
import { CalendarIcon, ClockIcon } from "lucide-react";
import { useState } from "react";
import { useNavigate } from "react-router";

export const SelectDatePage = () => {
  const [date, setDate] = useState<Date | undefined>(undefined);
  const navigate = useNavigate();

  return (
    <div className="flex flex-col items-center p-5 w-full">
      <div className="flex flex-col gap-10 w-full max-w-xl">
        <div className="w-full">
          <h1 className="text-center text-2xl font-thin">
            ¿Cuándo querés tu turno?
          </h1>
        </div>

        <div className="flex flex-col gap-3 w-full">
          <div className="flex gap-2 w-full">
            <CalendarIcon />
            <span>Fecha</span>
          </div>

          <div className="flex gap-5 w-full">
            <div className="grow">
              <Button
                onClick={() => setDate(new Date())}
                className="w-full cursor-pointer"
              >
                Hoy
              </Button>
            </div>
            <div className="grow">
              <Popover>
                <PopoverTrigger asChild>
                  <Button variant="outline" className="w-full flex">
                    <span>Elegí una fecha</span>
                    <CalendarIcon />
                  </Button>
                </PopoverTrigger>
                <PopoverContent className="w-auto p-0">
                  <Calendar
                    mode="single"
                    selected={date}
                    onSelect={(date) => setDate(date)}
                    captionLayout="dropdown"
                  />
                </PopoverContent>
              </Popover>
            </div>
          </div>
        </div>

        <div className="flex flex-col gap-3 w-full">
          <div className="flex gap-2">
            <ClockIcon />
            <span>Horario</span>
          </div>
          <div className="grid grid-cols-3 gap-3 w-full">
            <Toggle
              variant="outline"
              size="lg"
              className="p-5 text-xl font-thin cursor-pointer"
            >
              9:00
            </Toggle>
            <Toggle
              variant="outline"
              size="lg"
              className="p-5 text-xl font-thin cursor-pointer"
            >
              10:00
            </Toggle>
            <Toggle
              variant="outline"
              size="lg"
              className="p-5 text-xl font-thin cursor-pointer"
            >
              11:00
            </Toggle>
            <Toggle
              variant="outline"
              size="lg"
              className="p-5 text-xl font-thin cursor-pointer"
            >
              12:00
            </Toggle>
            <Toggle
              variant="outline"
              size="lg"
              className="p-5 text-xl font-thin cursor-pointer"
            >
              15:30
            </Toggle>
            <Toggle
              variant="outline"
              size="lg"
              className="p-5 text-xl font-thin cursor-pointer"
            >
              16:30
            </Toggle>
            <Toggle
              variant="outline"
              size="lg"
              className="p-5 text-xl font-thin cursor-pointer"
            >
              17:30
            </Toggle>
            <Toggle
              variant="outline"
              size="lg"
              className="p-5 text-xl font-thin cursor-pointer"
            >
              18:30
            </Toggle>
            <Toggle
              variant="outline"
              size="lg"
              className="p-5 text-xl font-thin cursor-pointer"
            >
              19:30
            </Toggle>
          </div>
        </div>

        <div className="flex w-full gap-5">
          <Button
            onClick={() => navigate(-1)}
            className="grow cursor-pointer"
            variant="secondary"
          >
            Atras
          </Button>
          <Button
            onClick={() => navigate("/reserva/servicios")}
            className="grow cursor-pointer"
          >
            Continuar
          </Button>
        </div>

        <div className="w-full"></div>
      </div>
    </div>
  );
};
