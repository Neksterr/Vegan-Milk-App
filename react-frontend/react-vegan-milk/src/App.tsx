import { BrowserRouter, Routes, Route } from "react-router-dom";

import { Login } from "@/features/auth/pages/Login";
import { Register } from "@/features/auth/pages/Register";
import { Landing } from "@/features/auth/pages/Landing";

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
