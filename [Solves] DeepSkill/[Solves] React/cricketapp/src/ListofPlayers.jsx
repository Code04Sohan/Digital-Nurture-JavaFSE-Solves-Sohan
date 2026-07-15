const players = [
    { name: 'Jack', score: 50 },
    { name: 'Michael', score: 70 },
    { name: 'John', score: 40 },
    { name: 'Ann', score: 61 },
    { name: 'Elisabeth', score: 61 },
    { name: 'Sachin', score: 95 },
    { name: 'Dhoni', score: 100 },
    { name: 'Virat', score: 84 },
    { name: 'Jadeja', score: 64 },
    { name: 'Raina', score: 75 },
    { name: 'Rohit', score: 80 }
]

function listOfPlayers({ players }) {
    return (
        <div>
            <div>
                <h1>List Of Players</h1>
            </div>

            {players.map((item) => (
                <div>
                    <li>Mr. {item.name} , <span> Score {item.score}</span></li>
                </div>
            ))}
        </div>
    );
}

function below70Players({ players }) {
    let player70 = [];
    players.map((item) => {
        if (item.score <= 70) {
            player70.push(item);
        }
        return null;
    });
    return (
        <div>
            <h1>List of Player Below 70</h1>
            {player70.map((item, index) => (
                <div key={index}>
                    <li>Mr. {item.name} <span>{item.score}</span></li>
                </div>
            ))}
        </div>
    );
}

export { listOfPlayers, below70Players , players };