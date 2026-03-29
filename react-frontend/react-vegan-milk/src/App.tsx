import { BrowserRouter, Routes, Route } from "react-router-dom";

import { Landing } from "@/features/auth/pages/Landing";
import { Register } from "./features/auth/pages/Register/Register";
import { Login } from "./features/auth/pages/Login/Login";
import { MapPage } from "./features/auth/pages/Map/MapPage";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Landing />} />
        <Route path="/register" element={<Register />} />
        <Route path="/login" element={<Login />} />
        <Route path="/map" element={<MapPage />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;