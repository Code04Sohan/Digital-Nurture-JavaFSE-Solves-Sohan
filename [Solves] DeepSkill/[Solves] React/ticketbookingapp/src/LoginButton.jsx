import React from 'react';

function LoginButton(props) {
    return (
        <button onClick={props.onClick} className="btn btn-primary">
            Login
        </button>
    );
}
export default LoginButton;
