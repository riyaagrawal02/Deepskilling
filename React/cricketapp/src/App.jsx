import ListOfPlayers from "./Components/ListOfPlayers";
import IndianPlayers from "./Components/IndianPlayers";

function App() {

    const flag = true;

    return (
        <div>

            <h1>Cricket App</h1>

            {
                flag
                    ? <ListOfPlayers />
                    : <IndianPlayers />
            }

        </div>
    );
}

export default App;