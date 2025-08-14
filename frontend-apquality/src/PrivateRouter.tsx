import { Navigate, Route, Routes } from "react-router";
import { Dashboard } from "./pages/Dashboard/Dashboard";

export const PrivateRouter = () => {
  return (
    <Routes>
      <Route path="/" element={<Navigate to="/dashboard" />} />
      <Route path="/dashboard" element={<Dashboard />} />
      <Route path="/about" element={<Dashboard />} />
      <Route path="/user" element={<Dashboard />} />
    </Routes>
  );
};
