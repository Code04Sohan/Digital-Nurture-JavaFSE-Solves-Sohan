import React from "react";
import ShowFlightDetails from "./showList";

function GuestPage({ isLoggedIn }) {
    return (
        <div>
            <h1>Please sign up.</h1>
            <ShowFlightDetails isLoggedIn={isLoggedIn} />
        </div>
    );
}

export default GuestPage;