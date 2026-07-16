import React from 'react';

function LogoutButton(props) {
    return (
        <button onClick={props.onClick} className="btn btn-secondary">
            Logout
        </button>
    );
}
export default LogoutButton;

