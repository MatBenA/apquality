import { Card, CardDescription, CardHeader, CardTitle } from "@/components/ui/card";

export const SelectLocationPage = () => {
  return (
    <div className="flex flex-col items-center w-full p-6">
      <div className="flex flex-col max-w-xl gap-5 w-full">
        <h1 className="text-center">¿Dónde preferís tu turno?</h1>
        <Card className="cursor-pointer hover:bg-secondary/90">
          <CardHeader>
            <CardTitle>🏪 En el Local</CardTitle>
            <CardDescription>Vení a nuestro local y relajate</CardDescription>
          </CardHeader>
        </Card>
        <Card className="cursor-pointer hover:bg-secondary/90">
          <CardHeader>
            <CardTitle>🏠 A Domicilio</CardTitle>
            <CardDescription>Te visitamos en tu casa</CardDescription>
          </CardHeader>
        </Card>
      </div>
    </div>
  );
}