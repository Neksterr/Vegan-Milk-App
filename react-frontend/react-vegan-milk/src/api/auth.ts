import axios from "axios";

export type AccountRegisterRequest = {
  email: string;
  username: string;
  password: string;
};

export type AccountLoginRequest = {
  email: string;
  password: string;
};

export type AccountRegisterResponse = {
  id: number;
  email: string;
  username: string;
  accountRole: string;
  token: string;
  message: string;
};

export type AccountLoginResponse = {
  id: number;
  email: string;
  username: string;
  accountRole: string;
  token: string;
  message: string;
};

const api = axios.create({
  baseURL: "http://localhost:8087/api/auth",
  headers: {
    "Content-Type": "application/json",
  },
});

export const register = (data: AccountRegisterRequest) =>
  api.post("/register", data);

export const login = (data: AccountLoginRequest) =>
  api.post("/login", data);

export default api;