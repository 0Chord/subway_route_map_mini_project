import React from "react";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Signup from "./pages/signup/Signup";
import MailAuth from "./pages/signup/MailAuth";
import AuthUser from "./pages/searchPassword/AuthUser";
import UpdatePassword from "./pages/signIn/UpdatePassword";
import LoginPage from "./pages/login/LoginPage";

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
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;
