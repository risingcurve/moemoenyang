const get = (urls: string, ...rest): Object => {
  const [url, query] = urls.split("?");

  let res = {
    status: 200,
    data: {},
  };
  let err = {
    status: 0,
    data: {
      msg: "",
    },
  };

  switch (url) { 
    case "/auth/check-email":
      res.data = {
        msg: "Y",
      };
      break;

    case url.startsWith("/univs") ? url : "없는케이스":
      res.data = {
        universities: [
          {
            university_id: 0,
            name: "인하대학교",
            address: "인천광역시 미추홀구 인하로 100",
          },
          {
            university_id: 1,
            name: "서울대학교",
            address: "서울특별시 관악구 관악로 1",
          },
          {
            university_id: 2,
            name: "북서울대학교",
            address: "서울특별시 북관악구 관악로 1",
          },
          {
            university_id: 3,
            name: "동서울대학교",
            address: "서울특별시 동관악구 관악로 1",
          },
          {
            university_id: 4,
            name: "남서울대학교",
            address: "서울특별시 남관악구 관악로 1",
          },
          {
            university_id: 5,
            name: "서서울대학교",
            address: "서울특별시 서관악구 관악로 1",
          },
          {
            university_id: 6,
            name: "북북서울대학교",
            address: "서울특별시 북북관악구 관악로 1",
          },
          {
            university_id: 7,
            name: "동동서울대학교",
            address: "서울특별시 동동관악구 관악로 1",
          },
          {
            university_id: 8,
            name: "남남서울대학교",
            address: "서울특별시 남남관악구 관악로 1",
          },
          {
            university_id: 9,
            name: "서서서울대학교",
            address: "서울특별시 서서관악구 관악로 1",
          },
        ],
      };
      break;

<<<<<<< HEAD
    case "/cat":
      res.data = {
        "cat_id":1,
        "name":"또롱이",
        "age":1,
        "gender":"male",
        "follower_cnt":"3",
        "image":"image"
      }
=======

>>>>>>> a30c208b19f03cdb0ed12dfc7a5716cbf59aea33

    default:
      break;
  }

  if (err.status) return Promise.reject(err);
  return Promise.resolve(res);
};

export default get;
