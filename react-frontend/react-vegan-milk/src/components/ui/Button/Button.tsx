import styles from "./Button.module.css";

type Props = {
  text: string;
  type?: "button" | "submit" | "reset";
  onClick?: () => void;
};

export const Button = ({
  text,
  type = "button",
  onClick,
}: Props) => {
  return (
    <button className={styles.button} type={type} onClick={onClick}>
      {text}
    </button>
  );
};