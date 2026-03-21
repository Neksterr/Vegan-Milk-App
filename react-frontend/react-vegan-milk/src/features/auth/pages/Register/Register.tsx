import { useNavigate } from "react-router-dom";
import styles from "./Register.module.css";
import { Input } from "@/components/ui/Input";
import { Button } from "@/components/ui/Button";

import bg from "@/assets/images/login-bg.png";
import logo from "@/assets/images/login-logo.png";
import apple from "@/assets/images/apple.svg";
import google from "@/assets/images/google.svg";
import { useState } from "react";
import { register } from "@/api/auth";

type RegisterForm = {
  email: string;
  username: string;
  password: string;
  confirmPassword: string;
};

export const Register = () => {
  const navigate = useNavigate();

  const [form, setForm] = useState<RegisterForm>({
    email: "",
    username: "",
    password: "",
    confirmPassword: "",
  });

  const [loading, setLoading] = useState<boolean>(false);
  const [error, setError] = useState<string>("");

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;

    setForm((prev) => ({
      ...prev,
      [name]: value,
    }));

    if (error) {
      setError("");
    }
  };

  const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
  e.preventDefault();
  setError("");

  if (!form.email || !form.username || !form.password || !form.confirmPassword) {
    setError("Please fill in all fields.");
    return;
  }

  if (form.password !== form.confirmPassword) {
    setError("Passwords do not match.");
    return;
  }

  try {
    setLoading(true);

    console.log("Submitting:", {
      email: form.email,
      username: form.username,
      password: form.password,
    });

    const response = await register({
      email: form.email,
      username: form.username,
      password: form.password,
    });

    console.log("Register success:", response.data);

    if (response.data?.token) {
      localStorage.setItem("token", response.data.token);
    }

    navigate("/login");
  } catch (err: any) {
  console.error("Register failed:", err);
  console.error("code:", err?.code);
  console.error("response:", err?.response);

  if (err?.code === "ERR_NETWORK") {
    setError("Cannot connect to backend.");
  } else {
    setError(
      err?.response?.data?.message ||
      err?.response?.data?.error ||
      err?.message ||
      "Registration failed."
    );
  }
}}

  return (
    <div className={styles.wrapper} style={{ backgroundImage: `url(${bg})` }}>
      <div className={styles.content}>
        <img
          src={logo}
          alt="Smart Vegan Milk Network"
          className={styles.logo}
        />

        <h1 className={styles.title}>Register</h1>

        <form onSubmit={handleSubmit} className={styles.card}>
          <Input
            icon="person"
            name="username"
            value={form.username}
            onChange={handleChange}
            placeholder="Username"
          />

          <Input
            icon="mail"
            type="email"
            name="email"
            value={form.email}
            onChange={handleChange}
            placeholder="Email"
          />

          <Input
            icon="lock"
            type="password"
            name="password"
            value={form.password}
            onChange={handleChange}
            placeholder="Password"
          />

          <Input
            icon="lock"
            type="password"
            name="confirmPassword"
            value={form.confirmPassword}
            onChange={handleChange}
            placeholder="Confirm Password"
          />

          {error && <p className={styles.error}>{error}</p>}

          <Button
            text={loading ? "Signing Up..." : "Sign Up"}
            type="submit"
          />

          <p className={styles.terms}>
            By signing up, you agree to the{" "}
            <span onClick={() => navigate("/terms")}>Terms of Service</span> and{" "}
            <span onClick={() => navigate("/privacy")}>Privacy Policy</span>
          </p>

          <div className={styles.divider}>
            <span>Already have an account?</span>
          </div>

          <div className={styles.socials}>
            <button className={styles.socialBtn} type="button">
              <img src={google} alt="Google" className={styles.socialIcon} />
            </button>

            <button className={styles.socialBtn} type="button">
              <img src={apple} alt="Apple" className={styles.socialIcon} />
            </button>
          </div>

          <p className={styles.loginText}>
            Already have an account?{" "}
            <span onClick={() => navigate("/login")}>Log in</span>
          </p>
        </form>
      </div>
    </div>
  );
};