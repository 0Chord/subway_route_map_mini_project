import axios from "axios";

export async function MailAuthUser(data, setError, history) {
    console.log(data)
    await axios.post('/user-service/signup/confirm-mail', data)
        .then(response => {
                console.log(response.data);
                setError("");
                if (response.data === "NotExistsEmail" || response.data === "WrongCode") {
                    setError(response.data);
                } else {
                    alert("이메일 인증이 성공하였습니다.");
                    history("/")
                }
            }
        )
        .catch(error => console.log(error));
}