import React,{useState} from "react";
import {searchStation} from "../../components/action/searchStation";
import {useNavigate, Link} from "react-router-dom";
import "./Home.css"
import "./login.css"
import logo from "../../assets/img/instagramLogo.png"

function Search() {
    const [StartStation, setStartStation] = useState("");
    const [EndStation, setEndStation] = useState("");
    const [StartStationError, setStartStationError] = useState("");
    const [EndStationError, setEndStationError] = useState("");

    const navigate = useNavigate();
    const onStartStationHandler = (event) => {
        setStartStation(event.currentTarget.value);
    }
    const onEndStationHandler = (event) => {
        setEndStation(event.currentTarget.value);
    }
    const onSubmitHandler = (event) => {
        // 버튼만 누르면 리로드 되는것을 막아줌
        event.preventDefault();

        console.log('startStation', StartStation);
        console.log('endStation', EndStation);

        let body = {
            startStation: StartStation,
            endStation: EndStation,
            token : localStorage.getItem("accessToken")
        }
        searchStation(body, setStartStationError, setEndStationError, navigate);
    }
    return (
        <div className={"contentsWrap"}>
            <form onSubmit={onSubmitHandler}>
                <div className={"loginWindow"}>
                    <img src={logo} alt={React}/>
                    <input type="text" value={StartStation} onChange={onStartStationHandler} placeholder={"출발역"}
                           className={"inlineToBlock"}/>
                    <span className="field-error">{StartStationError}</span>
                    <br/>
                    <input type="text" value={EndStation} onChange={onEndStationHandler} placeholder={"도착역"}
                           className={"inlineToBlock"}/>
                    <span className="field-error">{EndStationError}</span>
                    <br/>
                    <button formAction="" className="inlineToBlock ordinaryLogin activatedLoginColor">
                        검색하기
                    </button>
                </div>
            </form>
        </div>
    )
}

export default Search;