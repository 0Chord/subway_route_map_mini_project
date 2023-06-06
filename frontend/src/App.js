import React from "react";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Signup from "./pages/signup/Signup";
import MailAuth from "./pages/signup/MailAuth";
import AuthUser from "./pages/searchPassword/AuthUser";
import UpdatePassword from "./pages/signIn/UpdatePassword";
import LoginPage from "./pages/login/LoginPage";
import Search from "./pages/subway/Search";
import Result from "./pages/subway/Result";

function App() {
    return (
        <div className="App">
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<LoginPage/>}/>
                    <Route exact path={"/signup"} element={<Signup/>}/>
                    <Route exact path={"/signup/mailAuth"} element={<MailAuth/>}/>
                    <Route exact path={"/searchPassword"} element={<AuthUser/>}/>
                    <Route exact path={"/updatePassword"} element={<UpdatePassword/>}/>
                    <Route exact path={"/search/subway-map"} element={<Search/>}/>
                    <Route exact path={"/search/result"} element={<Result/>}/>
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;
