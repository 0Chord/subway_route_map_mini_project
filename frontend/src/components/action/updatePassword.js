import axios from "axios";

export async function updatePassword(data,setEmailError, setPasswordError){
    await axios.post("/user/update-password",data)
        .then(res=>{
            console.log(res.data)
        })
}