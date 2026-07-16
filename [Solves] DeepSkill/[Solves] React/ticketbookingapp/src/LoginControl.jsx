import React, { useState } from "react";
import UserPage from './UserPage.jsx';
import GuestPage from './GuestPage.jsx';
import LoginButton from './LoginButton.jsx';
import LogoutButton from './LogoutButton.jsx';

function LoginControl() {
    const [isLoggedIn, setIsLoggedIn] = useState(false);

    const handleLoginClick = () => {
        setIsLoggedIn(true);
    };

    const handleLogoutClick = () => {
        setIsLoggedIn(false);
    };

    let button;
    let page;

    if (isLoggedIn) {
        button = <LogoutButton onClick={handleLogoutClick} />
        page = <UserPage isLoggedIn={isLoggedIn} />;
    } else {
        button = <LoginButton onClick={handleLoginClick} />
        page = <GuestPage isLoggedIn={isLoggedIn} />;
    }

    return (
        <div>
            {page}
            
            {button}
        </div>
    );
}

export default LoginControl;