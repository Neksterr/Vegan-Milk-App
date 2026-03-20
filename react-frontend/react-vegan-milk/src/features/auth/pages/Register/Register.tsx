import { useNavigate } from "react-router-dom";
import styles from "./Register.module.css";
import { Input } from "@/components/ui/Input";
import { Button } from "@/components/ui/Button";

import bg from "@/assets/images/login-bg.png";
import logo from "@/assets/images/login-logo.png";
import apple from "@/assets/images/apple.svg";
import google from "@/assets/images/google.svg";

export const Register = () => {
  const navigate = useNavigate();

  return (
    <div className={styles.wrapper} style={{ backgroundImage: `url(${bg})` }}>
      <div className={styles.content}>
        <img
          src={logo}
          alt="Smart Vegan Milk Network"
          className={styles.logo}
        />

        <h1 className={styles.title}>Register</h1>

        <div className={styles.card}>
          <Input icon="person" placeholder="Full Name" />
          <Input icon="mail" placeholder="Email" />
          <Input icon="lock" type="password" placeholder="Password" />
          <Input
            icon="lock"
            type="password"
            placeholder="Confirm Password"
          />

          <Button text="Sign Up" onClick={() => navigate("/login")} />

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
            <span onClick={() => navigate("/")}>Log in</span>
          </p>
        </div>
      </div>
    </div>
  );
};