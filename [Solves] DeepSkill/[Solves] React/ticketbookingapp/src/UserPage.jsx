import React from 'react';
import ShowFlightDetails from './showList';

function UserPage({ isLoggedIn }) {
    return (
        <div>
            <h1>Welcome back!</h1>
            <ShowFlightDetails isLoggedIn={isLoggedIn} />
        </div>
    );
}
export default UserPage;