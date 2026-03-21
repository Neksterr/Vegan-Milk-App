import { ChangeEvent, FormEvent, useState } from "react";
import "./Register.css";
import { register, AccountRegisterRequest } from "../api/auth";

import logoImg from "../assets/logo-register.png";
import bgImg from "../assets/register-bg.png";

type RegisterForm = AccountRegisterRequest & {
  confirmPassword: string;
};

export default function Register() {
  const [form, setForm] = useState<RegisterForm>({
    email: "",
    username: "",
    password: "",
    confirmPassword: "",
  });

  const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
    setForm((prev) => ({
      ...prev,
      [e.target.name]: e.target.value,
    }));
  };

  const handleSubmit = async (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    if (form.password !== form.confirmPassword) {
      alert("Passwords do not match");
      return;
    }
    console.log(form.email,form.username,form.password);
    try {
      const payload: AccountRegisterRequest = {
        email: form.email,
        username: form.username,
        password: form.password,
      };

      const response = await register(payload);
      localStorage.setItem("token", response.data.token);
      alert("Registered successfully");
    } catch (error) {
      console.error(error);
      alert("Register failed");
    }
  };

  return (
    <div
      className="register-page"
      style={{ backgroundImage: `url(${bgImg})` }}
    >
      <div className="register-card">
        <img src={logoImg} alt="Vegan Milk" className="register-logo" />

        <h1 className="register-title">Register</h1>

        <form className="register-form" onSubmit={handleSubmit}>
          <div className="input-group">
            <span className="input-icon">👤</span>
            <input
              type="text"
              name="username"
              placeholder="Full Name"
              value={form.username}
              onChange={handleChange}
              required
            />
          </div>

          <div className="input-group">
            <span className="input-icon">✉️</span>
            <input
              type="email"
              name="email"
              placeholder="Email"
              value={form.email}
              onChange={handleChange}
              required
            />
          </div>

          <div className="input-group">
            <span className="input-icon">🔒</span>
            <input
              type="password"
              name="password"
              placeholder="Password"
              value={form.password}
              onChange={handleChange}
              required
            />
          </div>

          <div className="input-group">
            <span className="input-icon">🔒</span>
            <input
              type="password"
              name="confirmPassword"
              placeholder="Confirm Password"
              value={form.confirmPassword}
              onChange={handleChange}
              required
            />
          </div>

          <button type="submit" className="register-btn">
            Sign Up
          </button>
        </form>

        <p className="register-terms">
          By signing up, you agree to the <span>Terms of Service</span> and{" "}
          <span>Privacy Policy</span>
        </p>

        <div className="register-divider">
          <span />
          <p>Already have an account?</p>
          <span />
        </div>

        <div className="social-buttons">
          <button type="button" className="social-btn">
            G
          </button>
          <button type="button" className="social-btn">
            
          </button>
        </div>

        <p className="register-login">
          Already have an account? <a href="/login">Log in</a>
        </p>
      </div>
    </div>
  );
}