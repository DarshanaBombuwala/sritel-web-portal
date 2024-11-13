import axios from "axios";

const api = axios.create({
  baseURL: "http://localhost:8085", // Set a base URL if needed
});

const nonAuthApi = axios.create({
  baseURL: "http://localhost:8085", // Set a base URL if needed
});

// Set up the token interceptor
api.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem("token");
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

export default { api, nonAuthApi };