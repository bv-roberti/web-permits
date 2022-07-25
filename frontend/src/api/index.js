import axios from "axios";
import { API_URL } from "../config";
import { createContext, useContext } from "react";

export const useCurrentToken = () => {
  //return currentToken;
  return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NTgzNjMxMzQsInVzZXJfbmFtZSI6ImJ2X3JvYmVydGlAb3V0bG9vay5jb20iLCJqdGkiOiJsNEk1a0lCQ01ZcjIzcElKQ3dSNkhuSEZIb0EiLCJjbGllbnRfaWQiOiJ3ZWJwZXJtaXQiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXX0.oJJgjKCm165DV7F4ywBNqJ6UTgVIei5hNH5lHUA8Mxg";
};

export function createApiResponseSuccess(data) {
  return { success: true, data };
}

export function getUser() {
  const token = useCurrentToken();

  return axios({
    method: "GET",
    url: `${API_URL}/user`,
    headers: { Authorization: `Bearer ${token}` },
  }).then((response) => createApiResponseSuccess(response.data));
}

export function createUser() {
  const token = useCurrentToken();

  return axios({
    method: "POST",
    url: `${API_URL}/user`,
    data: {
      ...rest,
      env: environment,
    },
    headers: { Authorization: `Bearer ${token}` },
  }).then((response) => createApiResponseSuccess(response.data));
}

export function getCompany() {
  const token = useCurrentToken();

  return axios({
    method: "GET",
    url: `${API_URL}/company`,
    headers: { Authorization: `Bearer ${token}` },
  }).then((response) => createApiResponseSuccess(response.data));
}
