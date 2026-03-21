import { BrowserRouter, Routes, Route } from "react-router-dom";

import { Landing } from "@/features/auth/pages/Landing";
import { Register } from "./features/auth/pages/Register/Register";
import { Login } from "./features/auth/pages/Login/Login";

// later:
// import { Home } from "@/features/home/pages";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Landing />} />
        <Route path="/register" element={<Register />} />
        <Route path="/login" element={<Login />} />
        {/* <Route path="/home" element={<Home />} /> */}
      </Routes>
    </BrowserRouter>
  );
}

export default App;
