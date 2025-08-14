import { Navigate, Outlet } from "react-router";

export const PrivateGuard = () => {
  const token = localStorage.getItem("token");
  return token ? <Outlet /> : <Navigate to="/private/dashboard" replace />;
};
