import axios from "axios";

export async function loginUser(
  data,
  setEmailError,
  setPasswordError,
  history
) {
  await axios
    .post("/user-service/login", data)
    .then((response) => {
      setEmailError("");
      setPasswordError("");
      if (response.data === "NotFoundUser") {
        setEmailError("사용자를 찾을 수 없습니다.");
        history("/");
      } else if (response.data === "WrongPassword") {
        setPasswordError("비밀번호가 일치하지 않습니다.");
        history("/");
      } else if (response.data === "NotEmailAuthUser") {
        history("/signup/mailAuth", { state: { email: data.email } });
      }
      const accessToken = response.headers.get("accessToken");
      localStorage.setItem("accessToken", accessToken);
      history("/search/subway-map");
    })
    .catch((error) => console.log(error));
}
