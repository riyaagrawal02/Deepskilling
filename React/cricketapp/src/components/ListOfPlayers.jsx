function ListOfPlayers() {

    const players = [
        { name: "Virat Kohli", score: 95 },
        { name: "Rohit Sharma", score: 82 },
        { name: "Shubman Gill", score: 45 },
        { name: "KL Rahul", score: 67 },
        { name: "Hardik Pandya", score: 72 },
        { name: "Ravindra Jadeja", score: 64 },
        { name: "MS Dhoni", score: 88 },
        { name: "Suryakumar Yadav", score: 55 },
        { name: "Ruturaj Gaikwad", score: 78 },
        { name: "Yashasvi Jaiswal", score: 40 },
        { name: "Ishan Kishan", score: 61 }
    ];

    const players70 = players.filter(player => player.score <= 70);

    return (
        <div>

            <h2>List of Players</h2>

            <ul>
                {players.map((player, index) => (
                    <li key={index}>
                        {player.name} - {player.score}
                    </li>
                ))}
            </ul>

            <h2>Players with Score ≤ 70</h2>

            <ul>
                {players70.map((player, index) => (
                    <li key={index}>
                        {player.name} - {player.score}
                    </li>
                ))}
            </ul>

        </div>
    );
}

export default ListOfPlayers;