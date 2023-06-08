import React, {useState, useEffect} from "react";
import {useLocation, useNavigate, Link} from "react-router-dom";
import "./Home.css"
import "./login.css"
import logo from "../../assets/img/instagramLogo.png"
import axios from "axios";

function Result() {
    let location = useLocation();

    const [Result, setResult] = useState("");
    const [Hour, setHour] = useState("");
    const [Minute, setMinute] = useState("");

    useEffect(() => {
        const result = parseInt(parseInt(location.state.result.toString()) / 60);
        const hour = parseInt(result / 60)
        const minute = result - hour * 60;
        setResult(result);
        setHour(hour);
        setMinute(minute);
        console.log(result);
    }, [])


    return (
        <div className={"contentsWrap"}>
            <div className={"loginWindow"}>
                <img src={logo} alt={React}/>
                <input type="text" value={"                   "+Hour + "시간 "+Minute + "분"}
                       className={"inlineToBlock"} readOnly/>
                <Link to={"/search/subway-map"}>
                    <button formAction="" className=" ordinaryLogin activatedLoginColor">
                        검색하러가기
                    </button>
                </Link>
            </div>

        </div>

    )
}

export default Result;