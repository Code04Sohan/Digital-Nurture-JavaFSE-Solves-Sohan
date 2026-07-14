import React from "react"
import './App.css';
class CountPeople extends React.Component {
    constructor() {
        super();
        this.state = {
            entryCount: 0,
            exitCount: 0,
            c: 0
        };
    }

    updatEntry() {
        this.setState((prevState, props) => {
            console.log("Pressed")
            return { entryCount: prevState.entryCount + 1 }
        });
    }

    updateExit() {
        this.setState((prevState, props) => {
            console.log("Pressed")
            return { exitCount: prevState.exitCount + 1 }
        });
    }

    render() {
        return (
            <div className="app-container ">
                <div>
                    <button onClick={() => this.updatEntry()} className="action-button">Enter</button>
                    <span> [{this.state.entryCount}] People Entered</span>
                </div>
                <div>
                    <button onClick={() => this.updateExit()} className="action-button">Exit</button>
                    <span> [{this.state.exitCount}] Peorple Exited</span>
                </div>
            </div>
        );
    }
}

export default CountPeople;