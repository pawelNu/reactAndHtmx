// import './App.css'

import { BrowserRouter, Route, Routes } from "react-router-dom";
import { TaskTableWithoutState } from "./components/task/TaskTableWithoutState";
import { TaskTableWithState } from "./components/task/TaskTableWithState";
import { MainPage, links } from "./components/task/Main";

function App() {
    return (
        <>
            <BrowserRouter>
                <Routes>
                    <Route path={links.mainPage} element={<MainPage />} />
                    <Route path={links.TaskTableWithoutState} element={<TaskTableWithoutState />} />
                    <Route path={links.TaskTableWithState} element={<TaskTableWithState />} />
                </Routes>
            </BrowserRouter>
        </>
    );
}

export default App;
