import { useState } from "react";
import styles from "./Input.module.css";

type Props = {
  icon: string;
  type?: string;
  placeholder: string;
  name?: string;
  value?: string;
  onChange?: (e: React.ChangeEvent<HTMLInputElement>) => void;
};

export const Input = ({
  icon,
  type = "text",
  placeholder,
  name,
  value,
  onChange,
}: Props) => {
  const [showPassword, setShowPassword] = useState(false);

  const isPassword = type === "password";
  const inputType = isPassword && showPassword ? "text" : type;

  return (
    <div className={styles.container}>
      <span className={`material-symbols-outlined ${styles.icon}`}>
        {icon}
      </span>

      <input
        type={inputType}
        name={name}
        value={value}
        onChange={onChange}
        placeholder={placeholder}
        className={styles.input}
      />

      {isPassword && (
        <button
          type="button"
          className={styles.iconButton}
          onClick={() => setShowPassword((prev) => !prev)}
          aria-label={showPassword ? "Hide password" : "Show password"}
        >
          <span className={`material-symbols-outlined ${styles.iconRight}`}>
            {showPassword ? "visibility_off" : "visibility"}
          </span>
        </button>
      )}
    </div>
  );
};