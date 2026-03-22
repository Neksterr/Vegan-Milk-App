import { BrowserRouter, Routes, Route, Link } from "react-router-dom";

import { Login } from "@/features/auth/pages/Login";
import { Register } from "@/features/auth/pages/Register";
import { Landing } from "@/features/auth/pages/Landing";

// later:
// import { Home } from "@/features/home/pages";

function App() {
  return (
     <BrowserRouter>
      <nav style={{ display: "flex", gap: "12px", marginBottom: "20px" }}>
        <Link to="/register">Register</Link>
        <Link to="/login">Login</Link>
      </nav>

      <Routes>
        <Route path="/register" element={<Register />} />
        <Route path="/login" element={<Login />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
