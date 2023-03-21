import { Routes, Route } from "react-router-dom";
import Layout from "./common/Layout";
import AdminPage from "./pages/AdminPage";
import LandingPage from "./pages/LandingPage";
import LoginPage from "./pages/LoginPage";
import CatPage from "./pages/main/CatPage";
import MainPage from "./pages/main/MainPage";
import MapPage from "./pages/main/MapPage";
import ProfilePage from "./pages/main/ProfilePage";
import SymptomsPage from "./pages/main/SymptomsPage";
import NotFound404 from "./pages/NotFound404";
import SignupPage from "./pages/SignupPage";
import Board from "./pages/main/BoardPage";
import BoardHashTag from "./../src/components/board/BoardHashTag.jsx";
import PrivateRoute from "./router/PrivateRoute";
import PostBoard from "./components/board/PostBoard";
function App() {
  return (
    <Routes>
      <Route path="/" element={<LandingPage />} />
      <Route path="/login" element={<LoginPage />} />
      <Route path="/signup" element={<SignupPage />} />
      <Route path="/" element={<PrivateRoute component={<Layout />} />}>
        <Route path="main" element={<MainPage />} />
        <Route path="mypage" element={<ProfilePage />} />
        <Route path="catlist" element={<CatPage />} />
        <Route path="board" element={<PostBoard />} />
        <Route path="board/hashTag" element={<BoardHashTag />} />
        <Route path="symptoms" element={<SymptomsPage />} />
        <Route path="map" element={<MapPage />} />
      </Route>
      <Route path="/admin" element={<AdminPage />} />
      <Route path="*" element={<NotFound404 />} />
    </Routes>
  );
}

export default App;
