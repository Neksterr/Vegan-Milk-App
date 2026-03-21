import { useNavigate } from "react-router-dom";
import styles from "./Login.module.css";
import { Input } from "@/components/ui/Input";
import { Button } from "@/components/ui/Button";

import bg from "@/assets/images/login-bg.png";
import logo from "@/assets/images/login-logo.png";
import apple from "@/assets/images/apple.svg";
import google from "@/assets/images/google.svg";

export const Login = () => {
  const navigate = useNavigate();
  
  return (
    <div className={styles.wrapper} style={{ backgroundImage: `url(${bg})` }}>
      <div className={styles.content}>
        <img
          src={logo}
          alt="Smart Vegan Milk Network"
          className={styles.logo}
        />

        <h1 className={styles.title}>Login</h1>

        <div className={styles.card}>
          <Input icon="mail" placeholder="yourname@email.com" />
          <Input icon="lock" type="password" placeholder="••••••••" />

          <Button text="Log in" onClick={() => navigate("/login")} />

          <div className={styles.links}>
            <button
              type="button"
              className={styles.linkBtn}
              onClick={() => navigate("/forgot-password")}
            >
              Forgot password?
            </button>

            <span className={styles.or}>or</span>

            <button
              type="button"
              className={`${styles.linkBtn} ${styles.signup}`}
              onClick={() => navigate("/register")}
            >
              Sign up
            </button>
          </div>

          <div className={styles.divider}>
            <span>Or continue with</span>
          </div>

          <div className={styles.socials}>
            <button className={styles.socialBtn} type="button">
              <img src={google} alt="Google" className={styles.socialIcon} />
            </button>

            <button className={styles.socialBtn} type="button">
              <img src={apple} alt="Apple" className={styles.socialIcon} />
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};
