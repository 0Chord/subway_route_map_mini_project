import React, {useState, useEffect} from "react";
import {useLocation, useNavigate, Link} from "react-router-dom";
import "./Home.css"
import "./login.css"
import logo from "../../assets/img/instagramLogo.png"
import axios from "axios";

function Result() {
    let location = useLocation();

    const [Result, setResult] = useState("");

    useEffect(() => {

        const result = parseInt(parseInt(location.state.result.toString()) / 60);
        setResult(result);
        console.log(result);
    }, [])


    return (
        <div className={"contentsWrap"}>
            <div className={"loginWindow"}>
                <img src={logo} alt={React}/>
                <input type="text" value={Result}
                       className={"inlineToBlock"} readOnly/>
            </div>
        </div>
    )
}

export default Result;