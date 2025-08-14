import { BrowserRouter, Navigate, Route } from "react-router";
import { LoginPage } from "./pages/Login/LoginPage";
import { PrivateGuard } from "./guard/PrivateGuard";
import { PrivateRouter } from "./PrivateRouter";
import { RoutesWithNotFound } from "./components/RoutesWithNotFound";
import { SelectLocationPage } from "./pages/SelectLocation/SelectLocationPage";

export const AppRouter = () => {
  return (
    <BrowserRouter>
      <RoutesWithNotFound>
        <Route path="/" element={<Navigate to="/reserva/ubicacion" />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/reserva/ubicacion" element={<SelectLocationPage />}/>
        {/* <Route path="/reserva/horafecha" element={<SelectDateTimePage />}/>
        <Route path="/reserva/servicios" element={<SelectServicesPage />}/>
        <Route path="/reserva/resumen" element={<SummaryPage/>}/>
        <Route path="/reserva/confirmacion" element={<ConfirmationPage/>}/> */}
        <Route element={<PrivateGuard />}>
          <Route path="/private/*" element={<PrivateRouter />} />
        </Route>
      </RoutesWithNotFound>
    </BrowserRouter>
  );
};
