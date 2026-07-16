import React, {useState} from "react";

function Header(){
    const [value, setValue] = useState(0);
    const [message, setMessage] = useState('');
    const element = 'Hello';

    function increase() {
        const newValue = value + 1;
        setValue(newValue);
        setMessage(`${element}, ${newValue}`);
        alert(`${element}, value is now ${newValue}`);
    }

    function decrease() {
        const newValue = value - 1;
        setValue(newValue);
        setMessage(`${element}, ${newValue}`);
        alert(`${element}, value is now ${newValue}`);
    }

    function showMsg(text) {
        alert(text);
    }

    return(
        <div>
            <p>Value: {value}</p>
            {message && <p>{message}</p>}
            <div>
                <span>
                    <button onClick={increase}>Increase</button>
                    <button onClick={decrease}>Decrease</button>
                </span>
            </div>
            <div>
                <span>
                    <button onClick={() => showMsg("Welcome")}>Say Welcome</button>
                </span>
            </div>
        </div>
    );
}
export default Header;