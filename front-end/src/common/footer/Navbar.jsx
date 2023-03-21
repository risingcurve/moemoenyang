import React from "react";
import { AiOutlineHome } from "@react-icons/all-files/ai/AiOutlineHome";
import { RiBookletLine } from "@react-icons/all-files/ri/RiBookletLine";
import { RiHospitalLine } from "@react-icons/all-files/ri/RiHospitalLine";
import { BsPencil } from "@react-icons/all-files/bs/BsPencil";
import { BsPerson } from "@react-icons/all-files/bs/BsPerson";

import { useNavigate } from "react-router-dom";

export default function Navbar() {
  const navigate = useNavigate();

  const navigateToMain = () => {
    navigate("/main");
  };
  const navigateToCatlist = () => {
    navigate("/catlist");
  };
  const navigateToBoard = () => {
    navigate("/board");
  };
  const navigateToSymptoms = () => {
    navigate("/symptoms");
  };
  const navigateToMypage = () => {
    navigate("/mypage");
  };

  return (
    <div className="flex items-center justify-around h-12 bg-slate-100">
      <AiOutlineHome className="text-slate-900" onClick={navigateToMain} />
      <RiBookletLine className="text-slate-900" onClick={navigateToCatlist} />
      <BsPencil className="text-slate-900" onClick={navigateToBoard} />
      <RiHospitalLine className="text-slate-900" onClick={navigateToSymptoms} />
      <BsPerson className="text-slate-900" onClick={navigateToMypage} />
    </div>
  );
}
