import { Card, CardDescription, CardHeader, CardTitle } from "@/components/ui/card";
import { useNavigate } from "react-router";

export const SelectLocationPage = () => {
  const navigate = useNavigate();

  return (
    <div className="flex flex-col items-center w-full p-5">
      <div className="flex flex-col max-w-xl gap-5 w-full">
        <h1 className="text-center text-2xl font-thin">¿Dónde preferís tu turno?</h1>
        <Card className="cursor-pointer hover:bg-secondary/90" 
              onClick={() => navigate("/reserva/horafecha")}>
          <CardHeader>
            <CardTitle>🏪 En el Local</CardTitle>
            <CardDescription>Vení a nuestro local y relajate</CardDescription>
          </CardHeader>
        </Card>
        <Card className="cursor-pointer hover:bg-secondary/90" onClick={() => navigate("/reserva/direccion")}>
          <CardHeader>
            <CardTitle>🏠 A Domicilio</CardTitle>
            <CardDescription>Te visitamos en tu casa</CardDescription>
          </CardHeader>
        </Card>
      </div>
    </div>
  );
}