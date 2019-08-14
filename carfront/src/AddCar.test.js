import React from "react";
import AddCar from "./components/AddCar";
import Enzyme, { shallow } from "enzyme";
import Adapter from "enzyme-adapter-react-16";

Enzyme.configure({ adapter: new Adapter() });

describe("<AddCar />", () => {
  it("renders five <TextInput /> components", () => {
    const wrapper = shallow(<AddCar />);
    // Fails expects to have 5 but returns 0; to debug later maybe
    expect(wrapper.find("TextField")).toHaveLength(5);
  });
});
