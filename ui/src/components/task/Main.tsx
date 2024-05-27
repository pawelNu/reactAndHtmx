import { Link } from "react-router-dom";

export const links = {
    mainPage: "/",
    TaskTableWithoutState: "/TaskTableWithoutState",
    TaskTableWithState: "/TaskTableWithState",
};

export const MainPage = () => {
    return (
        <div>
            <nav>
                <ul>
                    <li>
                        <Link to={links.TaskTableWithoutState}>TaskTableWithoutState</Link>
                    </li>
                    <li>
                        <Link to={links.TaskTableWithState}>TaskTableWithState</Link>
                    </li>
                </ul>
            </nav>
        </div>
    );
};
