import axios from "axios";

const clearFunc = () => {
  window.location.reload();
};

export async function searchStation(
  data,
  setStartStationError,
  setEndStationError,
  history
) {
  await axios
    .post("/map-service/subway-routing", data)
    .then((response) => {
      console.log(response.data);
      setStartStationError("");
      setEndStationError("");
      if (response.data === "NotFoundStation") {
        setStartStationError("사용자를 찾을 수 없습니다.");
        history("/");
      }
      const accessToken = response.data["accessToken"];
      const refreshToken = response.data["refreshToken"];
      localStorage.setItem("accessToken", accessToken);
      localStorage.setItem("refreshToken", refreshToken);


      clearFunc();
    })
    .catch((error) => console.log(error));
}
