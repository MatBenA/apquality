import type { ReactNode } from "react";
import { Route, Routes } from "react-router";

interface Props {
  children: ReactNode;
}

export const RoutesWithNotFound = ({ children }: Props) => {
  return (
    <Routes>
      {children}
      <Route path="*" element={<h1>404 - Página no encontrada</h1>} />
    </Routes>
  );
};
