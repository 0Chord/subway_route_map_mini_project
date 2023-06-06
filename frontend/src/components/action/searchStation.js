import axios from "axios";
import header from "../instance/Header";

export async function searchStation(
    data,
    setStartStationError,
    setEndStationError,
    history
) {
    await axios
        .post("/map-service/subway-routing", data, {headers: header(localStorage.getItem("accessToken"))})
        .then((response) => {
            console.log(response.data);
            setStartStationError("");
            setEndStationError("");
            if (response.data === "KeyError") {
                setStartStationError("지하철 역을 찾을 수 없습니다.");
                return history("/search/subway-map");
            }

            history("/search/result", {state: {result: response.data}});
        })
        .catch((error) => console.log(error));
}
